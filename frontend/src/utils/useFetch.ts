import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export const useFetch = <T>(apiFunc: Function) => {
  const navigate = useNavigate();
  const [data, setData] = useState<T>();
  const [isLoading, setIsLoading] = useState<boolean>(true);
  const [error, setError] = useState<boolean>(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await apiFunc();
        if (response && response.statusCode === 200) {
          setData(response.data.data);
          setIsLoading(false);
        } else if (response.statusCode === 403) {
          navigate("/login");
        }
      } catch (error) {
        setError(true);
      }
    };
    fetchData();
  }, [isLoading]);
  return [data, isLoading, error, setIsLoading] as const;
};
export default useFetch;
