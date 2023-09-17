// App.jsx
import React from 'react';
import './App.css'; // You can add your own styles here
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import BrowseEvents from './components/BrowsePage';
import Home from './components/Home';
import ProfilePage from './components/ProfilePage';
import BrowsePage from './components/BrowsePage';
import AddUser from './components/AddUser';
import GetUsers from "./components/GetUsers";
import CreateEvent from "./components/CreateEvent";
import RegisterForEvent from "./components/RegisterForEvent";

function App() {
  const path = window.location.pathname; // Get the current URL path

  // Conditionally render components based on the URL path
  let content;
  if (path === '/ProfilePage') {
    content = <ProfilePage />;
  } else if (path === '/BrowsePage') {
    content = <BrowsePage />;
  } else if (path === '/AddUser') {
    content = <AddUser />;
  } else if (path === '/GetUsers') {
    content = <GetUsers />;
  } else if (path === '/RegisterForEvent') {
    content = <RegisterForEvent />;
  } else if (path === '/CreateEvent') {
    content = <CreateEvent />;
  }
  else {
    content = <Home />;
  }

  return (
    <div className="App">
      {content}
    </div>
  );
}

export default App;