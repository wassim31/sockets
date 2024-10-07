#include <stdlib.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <stdio.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main(int argc, char **argv) 
{
    int network_socket;
    if ((network_socket = socket(AF_INET, SOCK_STREAM, 0)) == -1 ) {
        fprintf(stderr, "socket creation error");
        return -1;
    }
    
    struct sockaddr_in server_address = {
        .sin_family = AF_INET,
        .sin_port = htons(12345)
    };
    inet_aton("127.0.0.1", & (server_address.sin_addr));

    int connection_status;
    if ((connection_status = connect(network_socket, (struct sockaddr *) &server_address, sizeof(server_address))) == -1) {
        fprintf(stderr, "error can't connect");
    }

    char server_response[256];
    recv(network_socket, &server_response, sizeof(server_response),0);
    printf("%s", server_response);

    /*
     sendto(sockfd, message, strlen(message), 0, (const struct sockaddr *) &servaddr, sizeof(servaddr));

     recvfrom(sockfd, buffer, sizeof(buffer), 0, (struct sockaddr *) &servaddr, &len);
    */

    return 0;
}
