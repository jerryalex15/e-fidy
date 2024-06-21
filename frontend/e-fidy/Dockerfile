## STAGE 1: Build

# Use the official node image as the base image
FROM node:latest AS angular
# Set the working directory
WORKDIR /usr/src/app
# Add the source code to app
COPY ./ /usr/src/app/
# Clear the cache
RUN npm cache clean --force
# Install all the dependecies
RUN npm install
# Generate the build of the application
RUN npm run build --configuration=production

## STAGE 2: Run

# Use the official nginx image as the base image
FROM nginx:latest
# Copy the build output to repalce the default nginx contents.
COPY --from=angular /usr/src/app/dist/e-fidy /usr/share/nginx/html
# Expose port 80
EXPOSE 80



