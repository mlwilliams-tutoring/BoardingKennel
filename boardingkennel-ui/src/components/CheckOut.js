import React, { Component } from 'react';
import Utils from './Utils';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

class CheckOut extends Component {
    defaultState = {
        boardingDogs: []
    }

    constructor() {
        super();
        this.state = this.defaultState;
    }

    componentDidMount() {
        Utils.get("boardingDogs")
            .then(data => {
                this.setState({ boardingDogs: data });
            });
    }

    renderDog = dog => {
        return (
            <div className="grid-item">
                <Card bg="dark" border="darl">
                    <Card.Body>
                        <Card.Title>{dog.name}</Card.Title>
                        <Card.Text>Dog Breed: {dog.breed}</Card.Text>
                        <Card.Text>Dog Age: {dog.age}</Card.Text>
                        <Card.Text>Dog Kennel Size: {dog.kennelSize}</Card.Text>
                        <Button variant="primary">Check-out</Button>
                    </Card.Body>
                </Card>
            </div>
        );
    }

    render() {
        return (
            <div className="grid-page">
                {
                    this.state.boardingDogs.map(dog => {
                        return this.renderDog(dog);
                    })
                }
            </div>
        );
    }

}

export default CheckOut;