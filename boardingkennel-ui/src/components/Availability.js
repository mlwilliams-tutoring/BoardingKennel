import React, { Component } from 'react';

class Availability extends Component {
    render() {
        return (
            <div>
                <Table striped bordered hover variant="dark">
                    <thead>
                        <tr>
                            <th>Kennel Size</th>
                            <th>Number of Dogs Boarding</th>
                            <th>Number of Available Kennels</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>Small Kennel</th>
                            <td>6</td>
                            <td>9</td>
                        </tr>
                        <tr>
                            <th>Medium Kennel</th>
                            <td>2</td>
                            <td>8</td>
                        </tr>
                        <tr>
                            <th>Large Kennel</th>
                            <td>2</td>
                            <td>3</td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default Availability;