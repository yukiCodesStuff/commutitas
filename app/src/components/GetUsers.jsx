import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Navbar from "../Navbar";

function GetUsers() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        // Fetch user data from the API
        axios
            .get('http://localhost:8080/commutitas/users')
            .then((response) => {
                setUsers(response.data); // Update the users state with the fetched data
                setLoading(false); // Set loading to false once data is received
            })
            .catch((error) => {
                console.error('Error fetching users:', error);
                setLoading(false); // Set loading to false in case of an error
            });
    }, []); // The empty array [] means this effect runs once, similar to componentDidMount

    return (
        <div>
            <Navbar />
            <h2>User List</h2>
            {loading ? (
                <p>Loading...</p>
            ) : (
                <ul>
                    {users.map((user) => (
                        <li key={user.id}>
                            <strong>Name:</strong> {user.name} <br />
                            <strong>Email:</strong> {user.email} <br />
                            {/* Add more user information fields as needed */}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default GetUsers;
