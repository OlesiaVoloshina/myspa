import SwaggerUI from 'swagger-ui'
import 'swagger-ui/dist/swagger-ui.css';

const ui = SwaggerUI({
  dom_id: '#swagger',
  url: "http://localhost:8080/site/resourceapi/swagger.json"
});
