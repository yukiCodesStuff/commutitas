import React, { useState } from 'react';
import axios from 'axios';
import Navbar from "../Navbar";

function AddUser() {
    const [formData, setFormData] = useState({
        userName: 'john_doe',
        name: 'John Doe',
        location: 'TX',
        phoneNumber: '123-456-7890',
        email: 'john@example.com',
        accountType: 'GUEST',
        dietaryRestrictions: [],
        religion: 'AGNOSTIC',
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

    return (
        <div>
            <Navbar />
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
                    <select name="accountType" value={formData.accountType} onChange={handleInputChange}>
                        <option value="GUEST">Guest</option>
                        <option value="HOST">Host</option>
                    </select>
                </label>
                <br />
                <label>
                    Religious Affiliation:
                    <select name="accountType" value={formData.religion} onChange={handleInputChange}>
                        <option value="CHRISTIANITY">Christianity</option>
                        <option value="ISLAM">Islam</option>
                        <option value="AGNOSTIC">Agnostic</option>
                        <option value="HINDUISM">Hinduism</option>
                        <option value="BUDDHISM">Buddhism</option>
                        <option value="SIKHISM">Sikhism</option>
                        <option value="ALL">Open to all</option>
                    </select>
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
        </div>
    );
}

export default AddUser;
