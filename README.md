# Spring Security Implementation

Working Flow Of Spring Security

<img width="600" height="600" alt="image" src="https://github.com/user-attachments/assets/d2370645-e345-41b9-9cd9-88b21924285c" />

- Request Enters Filter Chain: Client request hits the application's security filter chain.
- Authentication Filter: Extracts credentials from the request.
- AuthenticationManager: Delegates authentication to an appropriate Authentication Provider.
- Authentication Provider (e.g., DaoAuthenticationProvider):
  - Calls UserDetailsService.loadByUsername() to fetch user details from the Database.
  - Uses PasswordEncoder.matches() to compare the provided password with the stored password.
- Successful Authentication: If credentials are valid, an authenticated Authentication object is created.
- Security Context: The authenticated Authentication object is stored in the Security Context for the current user.
- Authorization & Controller: Request proceeds to other filters (for authorization) and then to Your Application Controllers.
- Response: Application processes the request and sends a response back to the client.
