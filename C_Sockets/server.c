#include <stdlib.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <stdio.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main(int argc, char const *argv[])
{
    int server_socket;
    if ((server_socket = socket(AF_INET, SOCK_STREAM, 0)) == -1 ) {
        fprintf(stderr, "socket creation error");
        return -1;
    }
    
    struct sockaddr_in server_address = {
        .sin_family = AF_INET,
        .sin_port = htons(12345)
    };
    inet_aton("127.0.0.1", & (server_address.sin_addr));

    if ((bind(server_socket, (struct sockaddr *) &server_address, sizeof(server_address))) == -1) {
        fprintf(stderr, "error can't bind");
        return -1;
    }

    listen(server_socket,5);

    int client_socket_channel;
    if ((client_socket_channel = accept(server_socket,NULL,NULL)) == -1) {
        fprintf(stderr, "error can't connect client");
        return -1;
    } else {
        printf("client connected \n");
    }
    char sent_data[20] = "hello wassim";
    send(client_socket_channel, sent_data, sizeof(sent_data), 0);


    close(client_socket_channel);    
    return 0;
}

