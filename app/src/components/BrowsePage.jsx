import React, { useEffect, useState } from 'react';

const BrowseEvents = () => {
    const [events, setEvents] = useState([]);
    const apiUrl = 'http://localhost:8080/commutitas/event';

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

    return (
        <div>
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
                         {/*Add more event details as needed */}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default BrowseEvents;
