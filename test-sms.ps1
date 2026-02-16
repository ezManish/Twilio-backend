param(
    [string]$to = "+917906272840", # Default number if none provided
    [string]$message = "Kaisa hai bhai !!!!"
)

$url = "http://localhost:8082/api/sms/send"
$headers = @{
    "Content-Type" = "application/json"
}
$body = @{
    to = $to
    message = $message
} | ConvertTo-Json

try {
    $response = Invoke-RestMethod -Uri $url -Method Post -Headers $headers -Body $body -ErrorAction Stop
    Write-Host "Success! Response:" -ForegroundColor Green
    Write-Host $response
} catch {

    Write-Host "Error: $($_.Exception.Message)" -ForegroundColor Red
    if ($_.Exception.Response) {
        $reader = New-Object System.IO.StreamReader($_.Exception.Response.GetResponseStream())
        Write-Host "Details: $($reader.ReadToEnd())" -ForegroundColor Red
    }
}
