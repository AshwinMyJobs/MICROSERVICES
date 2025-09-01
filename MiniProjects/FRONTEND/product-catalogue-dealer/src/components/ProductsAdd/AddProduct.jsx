import React, { useState } from 'react'
import './AddProduct.css'


const AddProduct = () => {

  const [action, setAction] = useState("Add Products");

  return (
    <div className='container'>
      <div className='header'>
        <div className='text'>{action}</div>
        <div className='underline'></div>
      </div>
      <div className='inputs'>
        {action==="Login"?
          <></>
          :
            <div className='input'>
              <img src="" alt="" />
              <input type="text" placeholder='Category 1'/>
            </div>
        }
        <div className='input'>
          <img src="" alt="" />
          <input type="email" placeholder='Category 2'/>
        </div>
        <div className='input'>
          <img src="" alt="" />
          <input type="password" placeholder='Category 3'/>
        </div>
      </div>
      <div className='submit-container'>
        <div className={action==="Login"?"submit gray":"submit"} onClick={()=>{setAction("Sign Up")}}>Sign Up</div>
        <div className={action==="Sign Up"?"submit gray":"submit"} onClick={()=>{setAction("Login")}}>Login</div>
      </div>
    </div>
  )
}

export default AddProduct;