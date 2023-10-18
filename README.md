
# Weather Forecasting App

This Spring Boot application provides weather information using the OpenWeatherMap API.

## Contribution Guidelines

Thank you for considering contributing to this project! Below are some guidelines to help you get started:

- Fork the repository and clone it to your local machine.
- Create a new branch for your feature or bug fix.
- Ensure that your code follows the existing code style and structure.
- Test your changes thoroughly.
- Submit a pull request with a clear description of your changes and the problem it solves.

## Usage

You can use this application to retrieve weather information by city ID, ZIP code, or geographical coordinates. The following API calls are currently supported:

1. Retrieve weather by geographical coordinates: `/weather/your-location`
2. Retrieve weather by city ID: `/weather/by-city-id`
3. Retrieve weather by ZIP code: `/weather/by-zip-code`

For more information on the API and the parameters that can be used, please refer to the [OpenWeatherMap Current Weather API documentation](https://openweathermap.org/current).

## Installation

To run this application, you will need:

- Java 11 or higher
- Maven

## Configuration

The application requires an OpenWeatherMap API key to function. You can provide the API key in the `application.properties` file as follows:

```properties
openweathermap.api.key=YOUR_API_KEY

