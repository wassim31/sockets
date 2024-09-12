#include <stdio.h>
#include <pthread.h>

void* sayHello(void* arg) {
    printf("Hello from thread!\n");
    return NULL;
}

int main() {
    pthread_t thread;

    // Create a thread
    pthread_create(&thread, NULL, sayHello, NULL);

    // Wait for the thread to finish
    pthread_join(thread, NULL);

    printf("Main thread finished execution.\n");
    return 0;
}

