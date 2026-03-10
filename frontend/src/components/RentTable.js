export default function RentTable({rents})
{
    return <table border={1}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Klient</th>
            <th>Kola</th>
            <th>Slujitel</th>
            <th>DataZaemane</th>
            <th>DataVrushtane</th>
            <th>broidni</th>
            <th colSpan={2}>Operations</th>
          </tr>
        </thead>
        <tbody>
          {rents.map(rent =><tr key={rent.id}>
            <td>{rent.Id}</td>
            <td>{rent.klientName}</td>
            <td>{rent.avtomobil.specs.marka + " " + rent.avtomobil.specs.modelName + " " + rent.avtomobil.specs.godina}</td>
            <td>{rent.slujitelName}</td>
            <td>{new Date(rent.dataZaemane).toDateString()}</td>
            <td>{new Date(rent.dataVrushtane).toDateString()}</td>
            <td>{rent.broiDni}</td>
            <td>Edit</td>
            <td>Delete</td>
            </tr> 
          )}
        </tbody>
      </table>
}