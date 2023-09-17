// Profile.jsx
import React from 'react';

const Profile = () => {
  return (
    <div className="container">
      <h2>User Profile</h2>
      <form>
        <label htmlFor="username">Username:</label>
        <input type="text" id="username" name="username" required />

        <label htmlFor="password">Password:</label>
        <input type="password" id="password" name="password" required />

        <label htmlFor="userType">Account Type:</label>
        <input type="text" id="userType" name="userType" required />

        <label htmlFor="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" required />

        <label htmlFor="email">Email:</label>
        <input type="text" id="email" name="email" required />

        <label htmlFor="age">Age:</label>
        <input type="text" id="age" name="age" required />

        <label htmlFor="location">Location:</label>
        <input type="text" id="location" name="location" required />

        <label htmlFor="religion">Religion:</label>
        <input type="text" id="religion" name="religion" required />

        <label htmlFor="dietary">Dietary Restrictions:</label>
        <input type="text" id="dietary" name="dietary" required />

        <label htmlFor="bio">Bio:</label>
        <input type="text" id="bio" name="bio" required />

      </form>
    </div>
  );
};

export default Profile;