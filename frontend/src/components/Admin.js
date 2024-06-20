import React from "react";

class Admin extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      tickets: [],
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/tickets")
      .then((response) => response.json())
      .then((data) => {
        this.setState({ tickets: data });
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }

  render() {
    return (
      <div>
        <h1>Admin</h1>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Description</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {this.state.tickets.map((ticket) => (
              <tr key={ticket.id}>
                <td>{ticket.id}</td>
                <td>{ticket.name}</td>
                <td>{ticket.email}</td>
                <td>{ticket.dsc}</td>
                <td>{ticket.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Admin;
