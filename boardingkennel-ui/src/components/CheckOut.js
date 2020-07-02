import React, { Component } from 'react';
import Utils from './Utils';
import ClickCard from './ClickCard';
import Form from 'react-bootstrap/Form';

class CheckOut extends Component {
    defaultState = {
        boardingDogs: [],
        search: ''
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
    checkout = dog => {
        const postData = {
            id: dog.id
        }
        Utils.post("checkOutDog", postData)
            .then(data => {
                this.setState({ boardingDogs: data });
            });
    }

    onChange = event => {
        this.setState({ search: event.target.value });
    }

    render() {
        return (
            <div>
                <div className="search-bar">
                    <Form.Control type="text" placeholder="Search" onChange={this.onChange} />
                </div>
                <div className="grid-page">
                    {
                        this.state.boardingDogs.map(dog => {
                            const search = this.state.search;

                            if (search !== ''
                                && dog.name.toLowerCase().indexOf(search.toLowerCase()) === -1) {
                                return null;
                            }
                            return (<ClickCard
                                key={'dog-card' + dog.name}
                                target={dog}
                                title={dog.name}
                                text={<span><span>{'Dog Breed: ' + dog.breed}<br /></span>
                                    <span>{'Dog Age: ' + dog.age}<br /></span>
                                    <span>{'Kennel Size: ' + dog.kennelSize}</span></span>}
                                onButtonClick={this.checkout}
                            />);
                        })
                    }
                </div>
            </div>
        );
    }

}

export default CheckOut;