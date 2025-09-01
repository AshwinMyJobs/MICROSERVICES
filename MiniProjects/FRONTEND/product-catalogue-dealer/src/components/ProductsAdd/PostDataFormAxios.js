import React, { useState } from 'react';
import axios from 'axios';

function PostDataFormAxios() {
  const [formData, setFormData] = useState({ id: '', categoryLevel1: 'Clothes',categoryLevel2: 'Men', categoryLevel3: 'Shirts',subCatogeries:[]});
  const [responseMessage, setResponseMessage] = useState('');

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/product/save', formData);
      setResponseMessage(`Success: ${JSON.stringify(response.data)}`);
    } catch (error) {
      setResponseMessage(`Error: ${error.message}`);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="title"
        value={formData.title}
        onChange={handleChange}
        placeholder="Title"
      />
      <textarea
        name="body"
        value={formData.body}
        onChange={handleChange}
        placeholder="Body"
      ></textarea>
      <button type="submit">Submit</button>
      {responseMessage && <p>{responseMessage}</p>}
    </form>
  );
}

export default PostDataFormAxios;