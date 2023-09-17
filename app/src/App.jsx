// App.jsx
import React from 'react';
import './App.css'; // You can add your own styles here
import Home from './components/Home';
import ProfilePage from './components/ProfilePage';
import BrowsePage from './components/BrowsePage';
import AddUser from './components/AddUser';
import GetUsers from "./components/GetUsers";

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
  } else {
    content = <Home />;
  }

  return (
    <div className="App">
      {content}
    </div>
  );
}

export default App;