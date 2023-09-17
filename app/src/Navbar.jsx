// Navbar.jsx
import React from 'react';
import './NavBar.css'; // Import the CSS file for styling



const Navbar = () => {
  return (
    <div className="navbar">
      <a href="/Home">Communitas</a>
      <a href="/Home">Home</a>
      <a href="/BrowsePage">Browse</a>
      <a href="/ProfilePage">Profile</a>
      <a href="/AddUser">Add User</a>
      <a href="/GetUsers">Get Users</a>
      <br></br>
    <br></br>
    </div>
  );
};

export default Navbar;
