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
            <td>{rent.id}</td>
            <td>{rent.klient}</td>
            <td>{rent.car}</td>
            <td>{rent.slujitel}</td>
            <td>{rent.zaemane}</td>
            <td>{rent.vrushtane}</td>
            <td>{rent.broidni}</td>
            <td>Edit</td>
            <td>Delete</td>
            </tr> 
          )}
        </tbody>
      </table>
}