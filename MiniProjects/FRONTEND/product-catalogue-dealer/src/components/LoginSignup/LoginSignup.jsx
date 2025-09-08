import React, { useState } from 'react'
import './LoginSignup.css'
import person_icon from '../Assets/person.png'
import axios from 'axios';


const LoginSignup = () => {

  const [responseMessage, setResponseMessage] = useState('');
  const [action, setAction] = useState("Login");

  const [name, setName] = useState('');
  const handleNameChange = (e) => {
    setName(e.target.value);
  }

  const [email, setEmail] = useState('');
  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  }

  const [password, setPassword] = useState('');
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
  }

  const handleSignUpSubmit = async (e) => {
    e.preventDefault();
    console.log("handleSignUpSubmit function is called.......");
    console.log("Name entered is : " + name);
    try {
      const response = await axios.post('http://localhost:8080/login/register', JSON.stringify({ name, email, password }), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      console.log(response.data)
    } catch (error) {
      setResponseMessage(`Error: ${error.message}`);
    }
  };

  const handleLoginSubmit = async (e) => {
    e.preventDefault();
    console.log("handleLoginSubmit function is called.......");
    console.log("Name entered is : " + name);
    console.log("Password entered is : " + password);
    try {
      const response = await axios.post('http://localhost:8080/login/authenticate', JSON.stringify({ name, password }), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      localStorage.setItem('jwtToken', response.data);
      if (JSON.stringify(response.data) === JSON.stringify("Invalid Username or Passsword"))
        window.location.href = '/';
      else
        window.location.href = '/useractions';
    } catch (error) {
      setResponseMessage(`Error: ${error.message}`);
    }

    // console.log("Now calliing prequthorize method with jwt");
    // try {
    //   const response = await axios.get('http://localhost:8080/login/helloAuthorized', {
    //     headers: {
    //       'Content-Type': 'application/json',
    //       'Authorization': `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTc1NzMwOTU0MywiZXhwIjoxNzU3MzExMzQzfQ.-13n_ycNXKh3pCn0wmZo6QXZSiNRfRsYG5KvdT_Va60`
    //     }
    //   });
    //   console.log("Response : " + JSON.stringify(response.data));

    // } catch (error) {
    //   setResponseMessage(`Error: ${error.message}`);
    //   window.location.href = '/';
    // }
  };


  return (
    <div className='container'>
      <form >
        <div className='header'>
          <div className='text'>{action}</div>
          <div className='underline'></div>
        </div>
        <div className='submit-container'>
          <div className={action === "Login" ? "submit gray" : "submit"} onClick={() => { setAction("Sign Up") }} onSubmit={handleSubmit}>Sign Up</div>
          <div className={action === "Sign Up" ? "submit gray" : "submit"} onClick={() => { setAction("Login") }}>Login</div>
        </div>
        <div className='inputs'>
          {action === "Login" ?
            <>
              <div className='input'>
                <input type="text" placeholder='Name' id='name' onChange={handleNameChange} />
              </div>
              <div className='input'>
                <input type="password" placeholder='Password' id='password' onChange={handlePasswordChange} />
              </div>
            </>
            :
            <>
              <div className='input'>
                <input type="text" placeholder='Name' id='name' onChange={handleNameChange} />
              </div>
              <div className='input'>
                <input type="email" placeholder='Email Id' id='email' onChange={handleEmailChange} />
              </div>
              <div className='input'>
                <input type="password" placeholder='Password' id='password' onChange={handlePasswordChange} />
              </div>
            </>
          }

        </div>
        {action === "Sign Up" ?
          <>
            <div align='center'>
              <button type='submit' onClick={handleSignUpSubmit}>Submit</button>
            </div>
          </>
          :
          <>
            <div className="forgot-password">Lost Password? <span>Click Here!</span></div>
            <div align='center'>
              <button type='submit' onClick={handleLoginSubmit}>Submit</button>
            </div>
          </>
        }
      </form>
    </div>
  )
}

export default LoginSignup;