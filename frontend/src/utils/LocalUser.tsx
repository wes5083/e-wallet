import { LoginUserProps } from "../interfaces/LoginUserProps";
const LOCAL_USER_KEY = "user_info";

export const isLogined = () => {
  if (localStorage.getItem(LOCAL_USER_KEY)) {
    return true;
  }
  return false;
};

export const getLoginUser = () => {
  let localUserString = localStorage.getItem(LOCAL_USER_KEY);
  return localUserString ? JSON.parse(localUserString) : {};
};

export const setLoginUser = (loginUser: LoginUserProps) => {
  localStorage.setItem(LOCAL_USER_KEY, JSON.stringify(loginUser));
};

export const clearLoginUser = () => {
  localStorage.removeItem(LOCAL_USER_KEY);
};
