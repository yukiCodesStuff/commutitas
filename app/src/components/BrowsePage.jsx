import React, { useEffect, useState } from 'react';
import Navbar from "../Navbar";
import RegisterForEvent from "./RegisterForEvent";
import {Link} from "react-router-dom";

const BrowseEvents = () => {
    const [events, setEvents] = useState([]);
    const apiUrl = 'http://localhost:8080/commutitas/event';
    const [selectedEvent, setSelectedEvent] = useState(null);

    useEffect(() => {
        // Fetch events from the specified URL when the component mounts
        const fetchEvents = async () => {
            try {
                const response = await fetch(apiUrl);
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const eventData = await response.json();
                setEvents(eventData);
            } catch (error) {
                // Handle errors
                console.error('Error:', error);
            }
        };

        fetchEvents();
    }, []);

    const handleRegisterClick = (event) => {
        // Set the selected event when the "Register" button is clicked
        setSelectedEvent(event);
    };

    return (
        <div>
            <Navbar />
            <h2>Browse Events</h2>
            <ul>
                {events.map((event, index) => (
                    <li key={index}>
                        <h3>{event.name}</h3>
                        <p>User: {event.userName}</p>
                        <p>Host: {event.hostName}</p>
                        <p>Religion: {event.religion}</p>
                        <p>Date: {event.date}</p>
                        <p>Time: {event.time}</p>
                        <p>City: {event.city}</p>
                        <p>Location: {event.location}</p>
                        <p>Age Limit: {event.ageLimit}</p>
                        <p>Attendees: {event.attendees}</p>
                        <a href="/RegisterForEvent">REGISTER</a>

                    </li>
                ))}
            </ul>
        </div>
    );
};

export default BrowseEvents;
