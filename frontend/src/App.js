import RentTable from "./components/RentTable";
import AddCarPage from "./pages/AddCarPage";

const rents = [
  {
    id:1,
    klient: "toshko",
    car: "Golf 4",
    slujitel: "Pesho",
    zaemane: "2025-01-01",
    broidni: 9,
    vrushtane: "2025-01-10",
  },
];

function App() {
  return (
    <div><div>
      Menu?      
    </div>
      <RentTable rents={rents}/>
      <AddCarPage/>
    </div>
  );
}

export default App;
