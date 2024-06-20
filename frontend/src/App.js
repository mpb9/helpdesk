import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import "./App.css";
import Admin from "./components/Admin";
import Home from "./components/Home";

function App() {
  return (
    <div className="App">
      <div className="App-header">
        <h2>Home</h2>
        <h2 className="App-admin">Admin</h2>
      </div>
      <Home></Home>
      <Admin></Admin>
    </div>
  );
}

export default App;
