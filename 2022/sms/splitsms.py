# SMS RFC: https://datatracker.ietf.org/doc/html/rfc5724

import tkinter as tk

# -- Constants --
# in fact, depends on the character-set:
# - 160 for 7-bit ASCII
# - 140 for 8-bit charset
# - 70 for 16-bit charset (for emojis by example)
# but we will use it for now because that's a fast
# script I don't want to dedicate much time to
ONE_SMS_LENGTH = 70
MAX_CONCATENATED_SMS = 8

# -- Code --
def process_message():
    message = tkcomp_text_input.get(1.0, "end-1c")
    words = message.split(" ")

    sms_list = []

    current_sms = ""

    for word in words:
        if len(current_sms) + len(word) + 1 < ONE_SMS_LENGTH * MAX_CONCATENATED_SMS:
            current_sms += word
            current_sms += " "
        else:
            current_sms = current_sms[:-1] # remove last " " char
            sms_list.append(current_sms)
            current_sms = word + " "

    if len(current_sms) > 0:
        sms_list.append(current_sms)

    for sms in sms_list:
        print(sms)
        print("______________")

frame = tk.Tk()
frame.title("SMS Splitter")
frame.geometry("1024x768")

tkcomp_summary = tk.Label(frame, text=f"A program made to transform your MMS into at most {MAX_CONCATENATED_SMS} concatenated SMS messages")
tkcomp_summary.pack()

tkcomp_text_input = tk.Text(frame, height=45, width=100)
tkcomp_text_input.pack()

tkcomp_process_btn = tk.Button(frame, text="Process", command = process_message)
tkcomp_process_btn.pack()

frame.mainloop()
