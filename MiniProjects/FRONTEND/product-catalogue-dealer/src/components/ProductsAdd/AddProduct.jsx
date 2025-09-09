import React, { useState } from 'react'
import './AddProduct.css'
import axios from 'axios';


const AddProduct = () => {

  const [responseMessage, setResponseMessage] = useState('');

  // const [formData, setFormData] = useState({ id: '', categoryLevel1: '', categoryLevel2: '', categoryLevel3: '', subCatogeries: [] });

  // const handleidChange = (e) => {
  //   setFormData({ ...formData, [e.target.name]: e.target.value });
  // };

  const [id, setId] = useState('');
  const [categoryLevel1, setCategoryLevel1] = useState('Men');
  const handleCategoryLevel1Change = (e) => {
    setCategoryLevel1(e.target.value);
  };
  const [categoryLevel2, setCategoryLevel2] = useState('Clothes');
  const handleCategoryLevel2Change = (e) => {
    setCategoryLevel2(e.target.value);
  };
  const [categoryLevel3, setCategoryLevel3] = useState('Pants');
  const handleCategoryLevel3Change = (e) => {
    setCategoryLevel3(e.target.value);
  };
  const [subCatogeries, setSubCatogeries] = useState('[]');

  const productRequestObject = { id, categoryLevel1, categoryLevel2, categoryLevel3 };

  const jwtToken = localStorage.getItem('jwtToken');

  const jsonRequestObject = {
    product: productRequestObject,
    jwtToken: jwtToken
  };


  const constructAddProductRequest = () => {
    return JSON.stringify(jsonRequestObject);
  }


  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(constructAddProductRequest());
    console.log("Now calliing prequthorize method with jwt");
    console.log("jwt Token is : " + localStorage.getItem('jwtToken'));

    const jwtToken = 'Bearer ' + localStorage.getItem('jwtToken');
    console.log("Authorization Token is : " + jwtToken);

    console.log("Form Data is : " + JSON.stringify({ id, categoryLevel1, categoryLevel2, categoryLevel3, subCatogeries }));

     try {
    //   const responseValidate = await axios.post('http://localhost:8080/api/jwt/validate', JSON.stringify({ id, categoryLevel1, categoryLevel2, categoryLevel3, subCatogeries }), {
    //     headers: {
    //       'Content-Type': 'application/json',
    //       'Authorization': jwtToken
    //     }
    //   });
    //   console.log("Response of validate method call: " + JSON.stringify(response.data));

      const response = await axios.post('http://localhost:8081/api/product/save', jsonRequestObject, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': jwtToken
        }
      });
      console.log("Response of validate method call: " + JSON.stringify(response.data));


    } catch (error) {
      // setResponseMessage(`Error: ${error.message}`);
      // console.log("Error is : " + responseMessage);
      //window.location.href = '/';
    }
  }

  return (
    <div className='container'>
      <form>
        <div className='header'>
          <div className='text'>Add Product</div>
          <div className='underline'></div>
        </div>
        <div className='inputs'>
          <div className='input'>
            <input type="text" id='categoryLevel1' placeholder='Category 1' onChange={handleCategoryLevel1Change} />
          </div>
          <div className='input'>
            <input type="text" id='categoryLevel2' placeholder='Category 2' onChange={handleCategoryLevel2Change} />
          </div>
          <div className='input'>
            <input type="text" id='categoryLevel3' placeholder='Category 3' onChange={handleCategoryLevel3Change} />
          </div>
        </div>
        <div align='center'>
          <button type='submit' onClick={handleSubmit}>Submit</button>
        </div>
      </form>
    </div>
  )
}

export default AddProduct;