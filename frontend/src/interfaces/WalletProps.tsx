import { UserProps } from "./UserProps";
import { WalletTransactionProps } from "./WalletTransactionProps";

export type WalletProps = {
  id: string;
  balance: string;
  currency: string;
  userVo: UserProps;
  walletTransactionVos?: WalletTransactionProps[];
};
