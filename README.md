# Twilio SMS Microservice

A standalone Spring Boot microservice for sending SMS messages via Twilio.

## Features
- **Send SMS**: Simple REST API to send text messages.
- **Logging**: Console logs for every request and response.
- **Error Handling**: Detailed error messages for debugging.

## Prerequisites
- **Java 17** or higher.
- **Maven** (optional, wrapper included or use IDE).
- **Twilio Account** (Account SID, Auth Token, and a Twilio Phone Number).

## Setup instructions

1.  **Clone the repository**:
    ```bash
    git clone <https://github.com/ezManish/Twilio-backend.git>
    cd Twilio-Service
    ```

2.  **Configure Credentials**:
    Copy the example configuration file:
    ```bash
    cp src/main/resources/application.properties.example src/main/resources/application.properties
    ```
    Open `src/main/resources/application.properties` and fill in your Twilio details:
    ```properties
    twilio.account_sid=YOUR_ACTUAL_SID
    twilio.auth_token=YOUR_ACTUAL_TOKEN
    twilio.phone_number=+1234567890
    ```
    > **Note**: `application.properties` is git-ignored to keep your secrets safe.

## Running the Application

You can run the application using Maven:
```bash
mvn spring-boot:run
```
Or simply run the `TwilioSmsApplication.java` file from your IDE (VS Code, IntelliJ).

**Server runs on**: `http://localhost:8082`

## API Usage

### Send SMS
**Endpoint**: `POST /api/sms/send`

**Request Body** (JSON):
```json
{
  "to": "+919876543210",
  "message": "Hello from Twilio Service!"
}
```

**Response**:
```text
SMS sent successfully! SID: SMxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

## Local Development

To run the application locally:

1.  **Configure Environment Variables**:
    Open the `.env` file in the project root and fill in your credentials:
    ```properties
    TWILIO_ACCOUNT_SID=your_actual_sid
    TWILIO_AUTH_TOKEN=your_actual_token
    TWILIO_PHONE_NUMBER=+1234567890
    ```
    *Note: The `.env` file is git-ignored to keep your secrets safe.*

2.  **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```
    The application will automatically load variables from `.env`.

## Testing

A PowerShell script is included to quickly test the service.

1.  Start the application.
2.  Open a new terminal.
3.  Run the script:
    ```powershell
    ./test-sms.ps1 -to "+919876543210" -message "Test Message"
    ```
    *(Replace with your verified phone number)*.

## Troubleshooting

- **Trial Account Error**: If you see an error about an "unverified number", you strictly need to add that phone number to your [Verified Caller IDs](https://console.twilio.com/us1/develop/phone-numbers/manage/verified-caller-ids) in the Twilio Console.
- **External Access**: To access this API from another device (e.g., phone), use your computer's local IP address (run `ipconfig` to find it) instead of `localhost`.
