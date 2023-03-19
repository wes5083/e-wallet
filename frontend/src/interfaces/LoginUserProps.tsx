import { UserType } from "./Status";
export type LoginUserProps = {
  id: string;
  username: string;
  type: UserType.ADMIN | UserType.GENERAL | UserType.OTHER;
};
