import APIRequest from "../utils/APIRequest";

const WalletService = {
  getWalletByUserId: (userId: string) => {
    const url = `/api/wallets/${userId}`;
    return APIRequest.get(url);
  },

  openWalletByUserId: (userId: string, currency: string) => {
    const url = `/api/wallets/open`;
    const params = {
      userId: userId,
      currency: currency,
    };
    return APIRequest.post(url, params);
  },

  topUpByUserId: (userId: string, amount: string) => {
    const url = `/api/wallets/topUp`;
    const params = {
      userId: userId,
      amount: amount,
    };
    return APIRequest.post(url, params);
  },

  withdrawByUserId: (userId: string, amount: string) => {
    const url = `/api/wallets/withdraw`;
    const params = {
      userId: userId,
      amount: amount,
    };
    return APIRequest.post(url, params);
  },

  transaction: (userId: string, toUserName: string, amount: string) => {
    const url = `/api/wallets/transaction`;
    const params = {
      userId: userId,
      amount: amount,
      toUserName: toUserName,
    };
    return APIRequest.post(url, params);
  },
};
export default WalletService;
