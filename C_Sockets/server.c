#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
int main(int argc, char **argv) {
    
    int server_socket = socket(AF_INET, SOCK_STREAM, 0);

    struct sockaddr_in server_address = {
        .sin_addr.s_addr = inet_addr("127.0.0.1"),
        .sin_family = AF_INET,
        .sin_port = htons(5000)
    };

    bind(server_socket, (struct sockaddr *) &server_address, sizeof(server_address));

    listen(server_socket, 5);

    int client_socket = accept(server_socket,NULL,NULL);
    
    char message[32] = "hello , it's server";
    send(server_socket, message, sizeof(message), 5);

    /* FOR UDP COMMUNICATIONS , USE THIS : */

    /*
     sendto(sockfd, message, strlen(message), 0, (const struct sockaddr *) &servaddr, sizeof(servaddr));

     recvfrom(sockfd, buffer, sizeof(buffer), 0, (struct sockaddr *) &servaddr, &len);
    */
    close(server_socket);
    return 0;
}