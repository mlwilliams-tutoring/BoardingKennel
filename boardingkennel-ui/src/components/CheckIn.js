import React, { Component } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { FormCheck } from 'react-bootstrap';
import Utils from './Utils';

class CheckIn extends Component {

    defaultState = {
        name: '',
        breed: '',
        age: '',
        allergies: '',
        amountOfFood: '',
        isFed: false,
        amountFed: '',
        kennelSize: '',
        showAmountFed: false
    };

    constructor() {
        super();
        this.state = this.defaultState;
    }

    onChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
    }

    onRadioChange = (e) => {
        if (e.target.id.includes("yes")) {
            this.setState({ [e.target.name]: true });
            this.setState({ showAmountFed: true });
        } else {
            this.setState({ [e.target.name]: false });
            this.setState({ showAmountFed: false })
        }

    }

    handleSubmit = (e) => {
        e.preventDefault(); //keeps page from refreshing
        console.log(this.state);
        let postData = {
            'breed': this.state.breed,
            'age': parseInt(this.state.age.charAt(0)),
            'name': this.state.name,
            'allergies': this.state.allergies,
            'amountOfFood': parseInt(this.state.amountOfFood),
            'amountFed': this.state.amountFed === 0 ? 0 : parseInt(this.state.amountFed),
            'isFed': this.state.isFed,
            'kennelSize': this.state.kennelSize.toUpperCase()
        };

        this.resetState();
        Utils.post("addDog", postData);
    }

    resetState() {
        this.setState({ ...this.defaultState });
    }

    render() {
        return (
            <div>
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group controlId="DogName">
                        <Form.Label>Name</Form.Label>
                        <Form.Control type="input" name="name"
                            value={this.state.name} onChange={this.onChange} />
                    </Form.Group>
                    <Form.Group controlId="DogBreed">
                        <Form.Label>Breed</Form.Label>
                        <Form.Control type="input" name="breed"
                            value={this.state.breed} onChange={this.onChange} />
                    </Form.Group>
                    <Form.Group controlId="DogAgeSelect">
                        <Form.Label>Age</Form.Label>
                        <Form.Control as="select" name="age"
                            value={this.state.age} onChange={this.onChange}>
                            <option>0 years</option>
                            <option>1 year</option>
                            <option>2 years</option>
                            <option>3 years</option>
                            <option>4 years</option>
                            <option>5 years</option>
                            <option>6 years</option>
                            <option>7 years</option>
                            <option>7+ years</option>
                        </Form.Control>
                    </Form.Group>
                    <Form.Group controlId="DogAllergies">
                        <Form.Label>Allergies (Food and Medication)</Form.Label>
                        <Form.Control as="textarea" rows="3" name="allergies"
                            value={this.state.allergies} onChange={this.onChange} />
                    </Form.Group>
                    <Form.Group controlId="DogFoodReqs">
                        <Form.Label>How much food does the dog eat in cups?</Form.Label>
                        <Form.Control type="input" name="amountOfFood"
                            value={this.state.amountOfFood} onChange={this.onChange} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Has your dog been fed today?</Form.Label>
                        <div key={'hasBeenFed'} className="mb-3">
                            <Form.Check inline onChange={this.onRadioChange}
                                name='isFed'
                                type='radio'
                                id='yes-fed'
                                label={`Yes`}
                                checked={this.state.isFed}
                            />
                            <FormCheck inline onChange={this.onRadioChange}
                                name='isFed'
                                type='radio'
                                id='no-fed'
                                label={`No`}
                                checked={!this.state.isFed}
                            />
                        </div>
                    </Form.Group>
                    <Form.Group controlId="DogFoodAlreadyFed"
                        className={this.state.showAmountFed ? '' : 'hidden'}>
                        <Form.Label>How much food in cups?</Form.Label>
                        <Form.Control type="input" name="amountFed"
                            value={this.state.amountFed} onChange={this.onChange} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Kennel Size</Form.Label>
                        <Form.Control as="select" name="kennelSize"
                            value={this.state.kennelSize} onChange={this.onChange}>
                            <option>Small</option>
                            <option>Medium</option>
                            <option>Large</option>
                        </Form.Control>
                    </Form.Group>
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </div>
        );
    }
}
export default CheckIn;
