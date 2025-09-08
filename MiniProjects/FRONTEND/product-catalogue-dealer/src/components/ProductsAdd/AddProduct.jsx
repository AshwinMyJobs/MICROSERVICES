import React, { useState } from 'react'
import './AddProduct.css'


const AddProduct = () => {

  const [action, setAction] = useState("Add Products");

  const handleSubmit = async (e) => {
    e.preventDefault();

    console.log("jwt Token is : " + localStorage.getItem('jwtToken'));
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
            <input type="text" placeholder='Category 1' />
          </div>
          <div className='input'>
            <input type="text" placeholder='Category 2' />
          </div>
          <div className='input'>
            <input type="text" placeholder='Category 3' />
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