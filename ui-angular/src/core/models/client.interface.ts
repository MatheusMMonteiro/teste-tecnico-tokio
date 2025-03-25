import { Address } from "./address.interface";

export interface Client {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    addresses: Address[];

}
export interface ClientRequest {
    firstName: string;
    lastName: string;
    email: string;
}

export interface ClientResponse extends ClientRequest {
    id: number;
    addresses: Address[];
}