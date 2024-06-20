import React from "react";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownButton from "react-bootstrap/DropdownButton";
import "./Admin.css";

class Admin extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      tickets: [],
    };
  }

  handleStatusChange(value, ticket) {
    if (ticket.status === value) {
      return;
    } else {
      fetch("http://localhost:8080/api/tickets", {
        method: "PUT",
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          id: ticket.id,
          name: ticket.name,
          email: ticket.email,
          dsc: ticket.dsc,
          status: value,
        }),
      })
        .then((response) => response.json())
        .then((data) => {
          console.log("Success:", data);
          alert("Ticket Status Updated Successfully");
          fetch("http://localhost:8080/api/tickets")
            .then((response) => response.json())
            .then((data) => {
              this.setState({ tickets: data });
            })
            .catch((error) => {
              console.error("Error:", error);
            });
        })
        .catch((error) => {
          console.error("Error:", error);
          alert("Error in updating ticket status");
        });
    }
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
      <div className="Admin">
        <h1>Admin</h1>
        <table>
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>Email</th>
              <th>Description</th>
              <th>Status</th>
              <th></th>
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
                <td>
                  <DropdownButton id="dropdown-basic-button" title="Update Status">
                    <Dropdown.Item onClick={() => this.handleStatusChange("new", ticket)}>new</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.handleStatusChange("in progress", ticket)}>in progress</Dropdown.Item>
                    <Dropdown.Item onClick={() => this.handleStatusChange("resolved", ticket)}>resolved</Dropdown.Item>
                  </DropdownButton>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default Admin;
