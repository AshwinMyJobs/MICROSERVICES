import React, { useEffect } from 'react';

function MyComponent() {
  useEffect(() =>{
                    console.log('Component has mounted and page loaded!');
                    console.log("jwt Token is : " + localStorage.getItem('jwtToken'));
                    // Any other code you want to run on mount
                 }, []
            ); // The empty dependency array ensures this runs only once on mount

  return (
    <div>
      <h1>Welcome to My Page</h1>
    </div>
  );
}

export default MyComponent;