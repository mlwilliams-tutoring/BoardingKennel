import React, { Component } from 'react';
import Utils from './Utils';
import ClickCard from './ClickCard';

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
    checkout = dog => {
        const postData = {
            id: dog.id
        }
        Utils.post("checkOutDog", postData)
            .then(data => {
                this.setState({ boardingDogs: data });
            });
    }

    render() {
        return (
            <div className="grid-page">
                {
                    this.state.boardingDogs.map(dog => {
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
        );
    }

}

export default CheckOut;