import { useEffect, useState } from "react";
import RentTable from "./components/RentTable";
import AddCarPage from "./pages/AddCarPage";

function App() {
  const [rents, setRents] = useState([]);

  useEffect(() => {
    async function fetchZaemi()
    {
      const response = await fetch("http://localhost:8081/zaemi");
      const resData = await response.json();
      setRents(resData);
    }

    fetchZaemi();
  }, []);
  console.log(rents);
  return (
    <div>
      <div>Menu?</div>
      <RentTable rents={rents} />
      <AddCarPage />
    </div>
  );
}

export default App;
