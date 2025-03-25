import { ClientResponse } from "./client.interface";

export interface Address {
    id: number;
    address: string;
    number: string;
    complement: string;
    postalCode: string;
    city: string;
    state: string;
    country: string;
    createdBy: ClientResponse;
}
export interface AddressCreate {
    address: string;
    number: string;
    complement: string;
    postalCode: string;
    city: string;
    state: string;
    country: string;
    clientId: number;
}