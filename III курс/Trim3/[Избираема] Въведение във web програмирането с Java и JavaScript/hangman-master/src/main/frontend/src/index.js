import React from "react";
import ReactDOM from "react-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import { Button, Container, Row, Col } from "reactstrap";

function App() {
  return (
    <Container>
      <Row>
        <Col size="auto">
          <h1>Wellcome to Hangout</h1>
          <p>You have 5 tries left</p>
          <p>A......B</p>
          <Button>Start new game</Button>
        </Col>
      </Row>
    </Container>
  );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);
