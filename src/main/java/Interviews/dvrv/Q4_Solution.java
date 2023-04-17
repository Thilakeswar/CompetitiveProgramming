package Interviews.dvrv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q4_Solution
{
	public static void main(String[] args) throws Exception
	{
		solution(new int[] {1000, 1500},
			new String[] {
				"withdraw 1613327630 2 480",
				"withdraw 1613327644 2 800",
				"withdraw 1614105244 1 100",
				"deposit 1614108844 2 200",
				"withdraw 1614108845 2 150"});

		solution(new int[] {20, 1000, 500, 40, 90},
			new String[] {
				"deposit 1613327630 3 400",
				"withdraw 1613327635 1 20",
				"withdraw 1613327651 1 50"});
	}

	//	public static void solution(int[] balances, String[] requests) throws Exception
	//	{
	//		System.out.println("Initial Balances : " + Arrays.toString(balances));
	//		TreeMap<Long, List<Request>> requestMap = new TreeMap<>();
	//		for(String request : requests)
	//		{
	//			String[] requestSplitted = request.split(" ");
	//			Request requestPOJO = new Request(requestSplitted[0], Long.valueOf(requestSplitted[1]), Integer.valueOf(requestSplitted[2]), Integer.valueOf(requestSplitted[3]));
	//			List<Request> requestList = new ArrayList<>();
	//			requestList.add(requestPOJO);
	//			requestMap.put(Long.valueOf(requestSplitted[1]), requestList);
	//		}
	//		for(Map.Entry<Long, List<Request>> entry : requestMap.entrySet())
	//		{
	//			List<Request> requestList = entry.getValue();
	//			for(Request request : requestList)
	//			{
	//				if(request.action.equals("cashback"))
	//				{
	//					balances[request.accountId-1] = balances[request.accountId-1] + request.amount;
	//					System.out.println("Cashback of " + request.amount + " processed at : " + request.timeStamp + " for accountId" + request.accountId + ". Balances : " + Arrays.toString(balances));
	//				}
	//			}
	//			for(Request request : requestList)
	//			{
	//				if(request.action.equals("deposit"))
	//				{
	//					balances[request.accountId-1] = balances[request.accountId-1] + request.amount;
	//					System.out.println("Deposit of " + request.amount + " processed at : " + request.timeStamp + " for accountId" + request.accountId + ". Balances : " + Arrays.toString(balances));
	//				}
	//				if(request.action.equals("withdraw"))
	//				{
	//					balances[request.accountId-1] = balances[request.accountId-1] - request.amount;
	//					Long cashbackTimeStamp = request.timeStamp + 24 * 60 * 60;
	//					int cashbackAmount = (int) Math.round(request.amount * 0.02);
	//					Request cashbackRequest = new Request("cashback", cashbackTimeStamp, request.accountId, cashbackAmount);
	//					List<Request> timestampRequests = new ArrayList<>();
	//					if(requestMap.containsKey(cashbackTimeStamp))
	//					{
	//						timestampRequests = requestMap.get(cashbackTimeStamp);
	//					}
	//					timestampRequests.add(cashbackRequest);
	//					requestMap.put(cashbackTimeStamp, timestampRequests);
	//					System.out.println("Withdrawal of " + request.amount + " processed at : " + request.timeStamp + " for accountId" + request.accountId + ". Balances : " + Arrays.toString(balances));
	//				}
	//			}
	//		}
	//	}

	public static void solution(int[] balances, String[] requests) throws Exception
	{
		System.out.println("Initial Balances : " + Arrays.toString(balances));
		Long lastRequestTimeStamp = null;
		List<Request> requestList = new LinkedList<>();
		for(String request : requests)
		{
			String[] requestSplitted = request.split(" ");
			String action = requestSplitted[0];
			Long timeStamp = Long.valueOf(requestSplitted[1]);
			int accountID = Integer.valueOf(requestSplitted[2]);
			if(accountID > balances.length)
			{
				throw new Exception("Invalid account number passed in the request : " + request);
			}
			int amount = Integer.valueOf(requestSplitted[3]);
			Request requestPOJO = new Request(action, timeStamp, accountID, amount);
			requestList.add(requestPOJO);
			lastRequestTimeStamp = requestPOJO.timeStamp;
		}
		for(int i = 0; i < requestList.size(); i++)
		{
			Request request = requestList.get(i);
			if(request.action.equals("cashback"))
			{
				balances[request.accountId - 1] = balances[request.accountId - 1] + request.amount;
				System.out.println("Cashback of " + request.amount + " processed at : " + request.timeStamp + " for accountId : " + request.accountId + ". Balances : " + Arrays.toString(balances));
			}
			if(request.action.equals("deposit"))
			{
				balances[request.accountId - 1] = balances[request.accountId - 1] + request.amount;
				System.out.println("Deposit of " + request.amount + " processed at : " + request.timeStamp + " for accountId : " + request.accountId + ". Balances : " + Arrays.toString(balances));
			}
			if(request.action.equals("withdraw"))
			{
				if(balances[request.accountId - 1] - request.amount < 0)
				{
					throw new Exception("Insufficient balance in the accountId : " + request.accountId + " Available Balance : " + balances[request.accountId - 1] + " Amount to be withdrawn : " + request.amount);
				}
				balances[request.accountId - 1] = balances[request.accountId - 1] - request.amount;
				Long cashbackTimeStamp = request.timeStamp + 24 * 60 * 60;
				if(cashbackTimeStamp < lastRequestTimeStamp)
				{
					int cashbackAmount = (int) Math.floor(request.amount * 0.02);
					Request cashbackRequest = new Request("cashback", cashbackTimeStamp, request.accountId, cashbackAmount);
					for(int j = i + 1; j < requestList.size(); j++)
					{
						Request nextRequest = requestList.get(j);
						if(nextRequest.timeStamp >= cashbackTimeStamp)
						{
							requestList.add(j, cashbackRequest);
							break;
						}
					}
				}
				System.out.println("Withdrawal of " + request.amount + " processed at : " + request.timeStamp + " for accountId : " + request.accountId + ". Balances : " + Arrays.toString(balances));
			}
		}
	}

	public static class Request
	{
		String action;
		Long timeStamp;
		int accountId;
		int amount;

		public Request(String action, Long timeStamp, int accountId, int amount)
		{
			this.timeStamp = timeStamp;
			this.action = action;
			this.accountId = accountId;
			this.amount = amount;
		}
	}
}
