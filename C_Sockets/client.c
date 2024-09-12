#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
int main(int argc, char **argv) {

    int network_socket = socket(AF_INET,SOCK_STREAM,0);
    
    struct sockaddr_in server_address = {
        .sin_addr.s_addr = inet_addr("127.0.0.1"),
        .sin_family = AF_INET,
        .sin_port = htons(5000)
    };

    int connection_status = connect(network_socket, (struct sockaddr *) &server_address, sizeof(server_address));

    char buffer[32];
    recv(network_socket , &buffer, sizeof(buffer), 0);
    
    printf("%s\n", buffer);

    /* FOR UDP COMMUNICATIONS , USE THIS : */

    /*
     sendto(sockfd, message, strlen(message), 0, (const struct sockaddr *) &servaddr, sizeof(servaddr));

     recvfrom(sockfd, buffer, sizeof(buffer), 0, (struct sockaddr *) &servaddr, &len);
    */
    close(network_socket);

    return 0;
}
