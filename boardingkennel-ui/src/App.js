import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav } from 'react-bootstrap';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Home from './components/Home';
import CheckIn from './components/CheckIn';
import Availability from './components/Availability';

function App() {
  return (
    <div className="App">
      <Router>
        <div className="App-header">
          <Navbar bg="dark" variant="dark" expanded="true" expand="lg" fixed="top">
            <Navbar.Brand href="/">Boarding Kennel</Navbar.Brand>
            <Nav className="mr-auto">
              <Nav.Link href="/checkin">Check-in Dog</Nav.Link>
              <Nav.Link href="/availability">Check Availability</Nav.Link>
            </Nav>
          </Navbar>
          <div className="component">
            <Route path="/" exact component={Home} />
            <Route path="/checkin" component={CheckIn} />
            <Route path="/availability" component={Availability} />
          </div>
        </div>
      </Router>
    </div>
  );
}

export default App;
