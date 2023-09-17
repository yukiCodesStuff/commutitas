import React, { useState } from 'react';
import axios from 'axios';
import Navbar from "../Navbar";

const EventCreator = () => {
    const [requestBody, setRequestBody] = useState({
        name: '',
        userName: '',
        hostName: '',
        religion: '',
        maxCapacity: 0,
        date: '',
        time: '',
        city: '',
        location: '',
        ageLimit: '',
        attendees: [],
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setRequestBody({
            ...requestBody,
            [name]: value,
        });
    };

    const handleSubmit = async () => {
        try {
            // const userName = 'your-username'; // Replace with the actual username
            // const apiUrl = `http://localhost:8080/commutitas/event/${userName}/create`;


            const apiUrl = `http://localhost:8080/commutitas/event/${requestBody.userName}/create`;

            // Make a POST request to the specified URL with the request body
            const response = await axios.post(apiUrl, requestBody);

            // Handle the response as needed
            console.log('Response:', response.data);
        } catch (error) {
            // Handle errors
            console.error('Error:', error);
        }
    };

    return (
        <div>
            <Navbar />
            <h2>Create Event</h2>
            <form>
                <label>
                    Name:
                    <input
                        type="text"
                        name="name"
                        value={requestBody.name}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    User Name:
                    <input
                        type="text"
                        name="userName"
                        value={requestBody.userName}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Host Name:
                    <input
                        type="text"
                        name="hostName"
                        value={requestBody.hostName}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Religion:
                    <input
                        type="text"
                        name="religion"
                        value={requestBody.religion}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Max Capacity:
                    <input
                        type="number"
                        name="maxCapacity"
                        value={requestBody.maxCapacity}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Date:
                    <input
                        type="text"
                        name="date"
                        value={requestBody.date}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Time:
                    <input
                        type="text"
                        name="time"
                        value={requestBody.time}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    City:
                    <input
                        type="text"
                        name="city"
                        value={requestBody.city}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Location:
                    <input
                        type="text"
                        name="location"
                        value={requestBody.location}
                        onChange={handleInputChange}
                    />
                </label>
                <label>
                    Age Limit:
                    <input
                        type="text"
                        name="ageLimit"
                        value={requestBody.ageLimit}
                        onChange={handleInputChange}
                    />
                </label>
                <button type="button" onClick={handleSubmit}>
                    Create Event
                </button>
            </form>
        </div>
    );
};

export default EventCreator;
