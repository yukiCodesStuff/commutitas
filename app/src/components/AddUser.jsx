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

    const handleDietaryRestrictionsChange = (e) => {
        const { name, value, checked } = e.target;
        let updatedDietaryRestrictions;

        if (checked) {
            // Add the value to the array if it's checked
            updatedDietaryRestrictions = [...formData.dietaryRestrictions, value];
        } else {
            // Remove the value from the array if it's unchecked
            updatedDietaryRestrictions = formData.dietaryRestrictions.filter(
                (restriction) => restriction !== value
            );
        }

        setFormData({
            ...formData,
            dietaryRestrictions: updatedDietaryRestrictions,
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
                    Dietary Restrictions:
                    <div>
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="FISH"
                                checked={formData.dietaryRestrictions.includes('FISH')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Fish
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="PEANUT_BUTTER"
                                checked={formData.dietaryRestrictions.includes('PEANUT_BUTTER')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Peanut Butter
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="SHELLFISH"
                                checked={formData.dietaryRestrictions.includes('SHELLFISH')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Shellfish
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="EGG"
                                checked={formData.dietaryRestrictions.includes('EGG')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Egg
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="MILK"
                                checked={formData.dietaryRestrictions.includes('MILK')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Milk
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="SOY"
                                checked={formData.dietaryRestrictions.includes('SOY')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Soy
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="dietaryRestrictions"
                                value="WHEAT"
                                checked={formData.dietaryRestrictions.includes('WHEAT')}
                                onChange={handleDietaryRestrictionsChange}
                            />
                            Wheat
                        </label>
                        <br />
                    </div>
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
