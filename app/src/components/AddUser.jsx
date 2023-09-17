import React, { useState } from 'react';
import axios from 'axios';

function AddUser() {
    const [formData, setFormData] = useState({
        userName: 'john_doe',
        name: 'John Doe',
        location: 'TX',
        phoneNumber: '123-456-7890',
        email: 'john@example.com',
        accountType: 'GUEST',
        dietaryRestrictions: [],
        religion: 'AGNOSITC',
        age: '30',
        bio: 'I am a software engineer with a passion for coding.'
    });

    const [isSubmitted, setIsSubmitted] = useState(false); // Track form submission
    const [newUser, setNewUser] = useState(null); // Store the new user data

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/commutitas', formData);
            console.log('Response:', response.data);

            // Update state to show success message and the new user
            setIsSubmitted(true);
            setNewUser(response.data); // Assuming the response contains the user data
        } catch (error) {
            console.error('Error:', error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    // const handleSubmit = async (e) => {
    //     e.preventDefault();
    //
    //     try {
    //         const response = await axios.post('http://localhost:8080/commutitas', formData);
    //         console.log('Response:', response.data);
    //     } catch (error) {
    //         console.error('Error:', error);
    //     }
    // };

    return (
        <div>
            <h1>Commutitas Registration</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input type="text" name="userName" value={formData.userName} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Full Name:
                    <input type="text" name="name" value={formData.name} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Location:
                    <input type="text" name="location" value={formData.location} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Phone Number:
                    <input type="text" name="phoneNumber" value={formData.phoneNumber} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Email:
                    <input type="text" name="email" value={formData.email} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Account Type:
                    <input type="text" name="accountType" value={formData.accountType} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Religion:
                    <input type="text" name="religion" value={formData.religion} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Age:
                    <input type="text" name="age" value={formData.age} onChange={handleInputChange} />
                </label>
                <br />
                <label>
                    Bio:
                    <textarea name="bio" value={formData.bio} onChange={handleInputChange}></textarea>
                </label>
                <br />
                <button type="submit">Submit</button>
            </form>
            <div>
                <h1>Commutitas Registration</h1>
                {isSubmitted ? (
                    <div>
                        <p>Registration Successful!</p>
                        <h2>New User:</h2>
                        <p>Username: {newUser.userName}</p>
                        <p>Full Name: {newUser.name}</p>
                        <p>Location: {newUser.location}</p>
                        {/* Add more user data here */}
                    </div>
                ) : (
                    <form onSubmit={handleSubmit}>
                        {/* ... Your form fields ... */}
                        <button type="submit">Submit</button>
                    </form>
                )}
            </div>
        </div>
    );
}

export default AddUser;
