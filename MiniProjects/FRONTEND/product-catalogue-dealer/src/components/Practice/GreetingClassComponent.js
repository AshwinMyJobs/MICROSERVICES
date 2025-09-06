import React, { Component } from 'react';


class GreetingClassComponent extends Component {

    render() {
        return (
            <>
                <div>This is from GreetingClassComponent !!!!!!!!!!!!!</div>
                <div>This is from GreetingClassComponent {this.props.name}!!!!!!!!!!!!!</div>
            </>
        );
    }
}
export default GreetingClassComponent;