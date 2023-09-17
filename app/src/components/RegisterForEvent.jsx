import React, { useState } from 'react';
import axios from 'axios';

function EventRegistration() {
    const [formData, setFormData] = useState({
        userName: '',
        eventName: '',
        hostName: '',
    });

    const [isRegistered, setIsRegistered] = useState(false);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            // Make a POST request to register for the event using the form data
            await axios.post(`http://localhost:8080/commutitas/${formData.userName}/register/${formData.eventName}/${formData.hostName}`);

            // Set the registration status to true
            setIsRegistered(true);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <div>
            <h1>Event Registration</h1>
            {isRegistered ? (
                <p>You have successfully registered for the event "{formData.eventName}" hosted by {formData.hostName}.</p>
            ) : (
                <form onSubmit={handleSubmit}>
                    <div>
                        <label>
                            Username:
                            <input
                                type="text"
                                name="userName"
                                value={formData.userName}
                                onChange={handleChange}
                                required
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Event Name:
                            <input
                                type="text"
                                name="eventName"
                                value={formData.eventName}
                                onChange={handleChange}
                                required
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Host Name:
                            <input
                                type="text"
                                name="hostName"
                                value={formData.hostName}
                                onChange={handleChange}
                                required
                            />
                        </label>
                    </div>
                    <button type="submit">Register for Event</button>
                </form>
            )}
        </div>
    );
}

export default EventRegistration;
